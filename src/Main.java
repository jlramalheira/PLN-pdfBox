import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import java.io.File;
import java.util.*;

public class Main {
    public static String removeStopWords(String text) {
        text = text.toLowerCase();
        text = text.replace("\n", " ");
        text = text.replace("”", "");
        text = text.replace("’", "");
        text = text.replace("“", "");
        text = text.replace("‘", "");
        text = text.replace(",", " , ");
        text = text.replace(".", " . ");
        text = text.replace(";", " ; ");
        text = text.replace(":", " : ");
        text = text.replace("?", " ? ");
        text = text.replace("&", " & ");
        text = text.replace("*", " * ");
        text = text.replace("-", " - ");
        text = text.replace("!", " ! ");
        text = text.replace(")", " ) ");
        text = text.replace("(", " ( ");
        text = text.replace("  ", " ");

        for (String stop : Util.getStopWords()) {
            text = text.replaceAll(stop, " ");
        }

        return text;
    }

    public static void findMoreCiteds(String text) {
        String[] words = text.split(" ");
        TreeMap<String, Integer> calculatedsMap = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!calculatedsMap.containsKey(word)) {
                calculatedsMap.put(word, 1);
            } else {
                calculatedsMap.put(word,calculatedsMap.get(word)+1);
            }
        }

        //TODO otimizar
        System.out.println("Termos mais utilizados:");
        String bigger = calculatedsMap.firstKey();
        int i = 0;
        while(i < 10) {
            for (String s : calculatedsMap.keySet()) {
                if ((calculatedsMap.containsKey(bigger) && calculatedsMap.containsKey(s)) && calculatedsMap.get(bigger) < calculatedsMap.get(s)) {
                    bigger = s;
                }
            }
            //TODO verificar se podemos ignorar caracteres aleatórios
            if (bigger.length() > 2) {
                System.out.println((++i) + ": " + bigger + " - " + calculatedsMap.get(bigger));
            }
            calculatedsMap.remove(bigger);
            bigger = calculatedsMap.firstKey();
        }

    }

    public static void extractReferences(String text){
        int indexReferences = text.lastIndexOf("References");
        if (indexReferences > 0) {
            int biggerEnd = 0;
            for (String topics : Util.getTopicsAfterReferences()) {
                int i = text.lastIndexOf(topics);
                if (i > biggerEnd){
                    biggerEnd = i;
                }
            }
            String references = "";
            if (biggerEnd < indexReferences){
                references = text.substring(indexReferences);
            } else {
                references = text.substring(indexReferences,biggerEnd);
            }
            String[] reference = references.split("\n");
            for (String r : reference) {
                if (r.length() > 3){
                    System.out.println(r);
                }
            }
        } else {
            System.out.println("Não foram encontradas referencias");
        }
    }

    public static void extractAuthor(String text){
        String textSeach = text.toLowerCase();
        int indexAuthor = -1;
        for (String name : Util.getNamesToAuthor()) {
            indexAuthor = textSeach.indexOf(name);
            if (indexAuthor > 0){
                break;
            }
        }

        if (indexAuthor < 0){
            System.out.println("Não foram encontrados autores");
        } else {
            int start;
            int end;
            int aux = indexAuthor;
            //dois \n para tras
            while (aux > 0 && text.charAt(aux) != '\n'){
                aux--;
            }
            aux--;
            while (aux > 0 && text.charAt(aux) != '\n'){
                aux--;
            }
            start = aux;
            aux = indexAuthor;
            //dois para frente
            while (aux < text.length() && text.charAt(aux) != '\n'){
                aux++;
            }
            aux++;
            while (aux < text.length() && text.charAt(aux) != '\n'){
                aux++;
            }
            end = aux;

            String authors = text.substring(start+1,end);
            System.out.println(authors);
        }

    }

    public static void extractObjective(String text){
        int indexObjective = text.indexOf("objective");
        if (indexObjective < 0){
            System.out.println("Não foram encontrados objetivos");
        } else {
            int start;
            int end;
            int aux = indexObjective;
            while (aux > 0 && text.charAt(aux) != '.'){
                aux--;
            }
            start = aux;
            aux = indexObjective;
            while (aux < text.length() && text.charAt(aux) != '.'){
                aux++;
            }
            end = aux;

            String objective = text.substring(start+1,end+1);
            System.out.println(objective);
        }
    }

    public static void extractProblem(String text){
        int indexProblem = text.indexOf("problem");
        if (indexProblem < 0){
            System.out.println("Não foram encontrados problemas deste trabalho");
        } else {
            int start;
            int end;
            int aux = indexProblem;
            while (aux > 0 && text.charAt(aux) != '.'){
                aux--;
            }
            start = aux;
            aux = indexProblem;
            while (aux < text.length() && text.charAt(aux) != '.'){
                aux++;
            }
            end = aux;

            String problem = text.substring(start+1,end+1);
            System.out.println(problem);
        }
    }

    public static void extractMethodology(String text){
        int indexMethod = text.indexOf("methodology");
        if (indexMethod < 0) {
            indexMethod = text.indexOf("method");
        }
        if (indexMethod < 0) {
            indexMethod = text.indexOf("interviews");
        }
        if (indexMethod < 0) {
            indexMethod = text.indexOf("survey");
        }
        if (indexMethod < 0) {
            indexMethod = text.indexOf("content analysis");
        }
        if (indexMethod < 0){
            System.out.println("Não foram encontradas metodologias deste trabalho");
        } else {
            int start;
            int end;
            int aux = indexMethod;
            while (aux > 0 && text.charAt(aux) != '.'){
                aux--;
            }
            start = aux;
            aux = indexMethod;
            while (aux < text.length() && text.charAt(aux) != '.'){
                aux++;
            }
            end = aux;

            String method = text.substring(start+1,end+1);
            System.out.println(method);
        }
    }

    public static void extractContributes(String text){
        int indexContributes = text.indexOf("contributes to");
        if (indexContributes < 0){
            System.out.println("Não foram encontrados contruiuições deste trabalho");
        } else {
            boolean search = true;
            while (search) {
                int start;
                int end;
                int aux = indexContributes;
                while (aux > 0 && text.charAt(aux) != '.') {
                    aux--;
                }
                start = aux;
                aux = indexContributes;
                while (aux < text.length() && text.charAt(aux) != '.') {
                    aux++;
                }
                end = aux;

                String contributes = text.substring(start+1, end + 1);
                if (contributes.contains("objective")) {
                    text = text.substring(indexContributes);
                    indexContributes = text.indexOf("contributes to");
                    if (indexContributes < 0){
                        System.out.println("Não foram encontrados contruiuições deste trabalho");
                        search = false;
                    }
                } else {
                    System.out.println(contributes);
                    search = false;
                }
            }
        }
    }

    public static void main(String[] args) {

        PDDocument pd;
        try {
            File input = new File("pdf/1.pdf");  // The PDF file from where you would like to extract
            pd = PDDocument.load(input);
            int numberOfPages = pd.getNumberOfPages();

            PDFTextStripper stripper = new PDFTextStripper();
            String fullText = stripper.getText(pd);

            int indexReferences = fullText.lastIndexOf("References\n");
            String textOutReferences = fullText.substring(0, indexReferences > 0 ? indexReferences: fullText.length());
            String textOutStop = removeStopWords(textOutReferences);

            findMoreCiteds(textOutStop);

            extractReferences(fullText);

            stripper.setEndPage(3);
            String startText = stripper.getText(pd);

            System.out.println("Autores");
            extractAuthor(startText);
            System.out.println("Objetivos");
            extractObjective(startText);
            System.out.println("\n\nProblemas");
            extractProblem(startText);
            System.out.println("\n\nMetodologia");
            extractMethodology(fullText);
            System.out.println("\n\nContribuições");
            extractContributes(fullText);
            pd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
