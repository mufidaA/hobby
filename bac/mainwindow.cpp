#include "mainwindow.h"
#include "./ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    connect(ui->calculateButton, SIGNAL(clicked()), this, SLOT(calculateBAC()));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::calculateBAC()
{
    // Get input values from UI
    QString gender = ui->genderComboBox->currentText();
    int bodyWeight = ui->weightSpinBox->value();
    double hoursSinceDrink = ui->hoursSpinBox->value();
    double alcVolume = ui->volumeSpinBox->value();
    double alcContent = ui->contentSpinBox->value();

    // Calculate BAC
    double genderCnst = (gender == "f") ? 0.55 : 0.68;
    double BAC = (alcContent * alcVolume * 0.789) / (bodyWeight * 1000 * genderCnst) - 0.015 * hoursSinceDrink;

    // Display result
    if (BAC < 0.08) {
        QString resultText = QString("The estimated BAC is %1 % is considered within the safe range for driving").arg(BAC, 0, 'f', 3);
        ui->resultLabel->setText(resultText);
    } else if (BAC >= 0.08) {
        QString resultText = QString("The estimated BAC is %1 % is considered above the safe range for driving").arg(BAC, 0, 'f', 3);
        ui->resultLabel->setText(resultText);
    } else {
        QString resultText = "Invalid input";
        ui->resultLabel->setText(resultText);
        return;
    }
}
