package com.auto_sales_management.managment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class FileManager {
    private static final String FORMAT = "%-15s %-15s %-15s";

    /**
     * Записывает отчет в указанный файл.
     *
     * @param fileName имя файла, в который будет записан отчет.
     * @param name имя менеджера, которое будет включено в отчет.
     * @param reportList список отчетов, содержащий данные о продажах.
     * @throws IOException если возникает ошибка при записи в файл.
     */
    public void writeToFile(String fileName, String name, List<Report> reportList) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            BigDecimal income = BigDecimal.ZERO;
            BigDecimal expenses = BigDecimal.ZERO;
            writer.write("Имя менеджера: " + name);
            writer.newLine();
            writer.write(String.format(FORMAT, "Модель", "Продажа", "Себестоимость"));
            writer.newLine();
            writer.write(String.format(FORMAT, "-------", "--------", "-----------"));
            writer.newLine();
            for (Report report : reportList) {
                income = income.add(report.getSallePrise());
                expenses = expenses.add(report.getCostPrice());
                writer.write(String.format(FORMAT,
                        report.getSalesCarType(),
                        String.format("%.2f", report.getSallePrise()),
                        String.format("%.2f", report.getCostPrice())));
                writer.newLine();
            }
            writer.write("\nДоходы: " + income);
            writer.write("\nРасходы: " + expenses);
            writer.write("\nПрибыль: " + income.subtract(expenses));
            writer.newLine();
        }
    }
}
