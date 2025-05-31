package mortalkombatbversion;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ResultsManager {
    private static final String FILE_NAME = "results.xlsx";
    private static final String SHEET_NAME = "Results";
    private File resultsFile;

    public ResultsManager() {
        String jarPath = System.getProperty("user.dir");
        resultsFile = new File(jarPath, FILE_NAME);
        if (!resultsFile.exists()) {
            createNewResultsFile();
        }
    }

    private void createNewResultsFile() {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(SHEET_NAME);
            
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Points");
            
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            try (FileOutputStream fileOut = new FileOutputStream(resultsFile)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addResult(String playerName, int points) {
        try (FileInputStream fis = new FileInputStream(resultsFile);
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            Sheet sheet = workbook.getSheet(SHEET_NAME);
            int lastRowNum = sheet.getLastRowNum() + 1;
            
            Row newRow = sheet.createRow(lastRowNum);
            newRow.createCell(0).setCellValue(playerName);
            newRow.createCell(1).setCellValue(points);
            
            try (FileOutputStream fileOut = new FileOutputStream(resultsFile)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<GameResult> getTopResults(int limit) {
        List<GameResult> results = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(resultsFile);
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            Sheet sheet = workbook.getSheet(SHEET_NAME);
            
            // Пропускаем заголовок
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    String name = row.getCell(0).getStringCellValue();
                    int points = (int) row.getCell(1).getNumericCellValue();
                    results.add(new GameResult(name, points));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Collections.sort(results, Comparator.comparingInt(GameResult::getPoints).reversed());
        
        return results.subList(0, Math.min(results.size(), limit));
    }

    public static class GameResult {
        private String playerName;
        private int points;

        public GameResult(String playerName, int points) {
            this.playerName = playerName;
            this.points = points;
        }

        public String getPlayerName() {
            return playerName;
        }

        public int getPoints() {
            return points;
        }
    }
} 