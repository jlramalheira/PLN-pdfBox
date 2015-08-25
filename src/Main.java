import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripper;
import java.io.File;
import java.util.*;

public class Main {


    public static String removeStopWords(String text) {
        List<String> stops = new ArrayList<>();

        stops.add(" a ");
        stops.add(" about ");
        stops.add(" above ");
        stops.add(" after ");
        stops.add(" again ");
        stops.add(" against ");
        stops.add(" all ");
        stops.add(" am ");
        stops.add(" an ");
        stops.add(" and ");
        stops.add(" any ");
        stops.add(" are ");
        stops.add(" aren't ");
        stops.add(" as ");
        stops.add(" at ");
        stops.add(" be ");
        stops.add(" because ");
        stops.add(" been ");
        stops.add(" before ");
        stops.add(" being ");
        stops.add(" below ");
        stops.add(" between ");
        stops.add(" both ");
        stops.add(" but ");
        stops.add(" by ");
        stops.add(" can't ");
        stops.add(" cannot ");
        stops.add(" could ");
        stops.add(" couldn't ");
        stops.add(" did ");
        stops.add(" didn't ");
        stops.add(" do ");
        stops.add(" does ");
        stops.add(" doesn't ");
        stops.add(" doing ");
        stops.add(" don't ");
        stops.add(" down ");
        stops.add(" during ");
        stops.add(" each ");
        stops.add(" few ");
        stops.add(" for ");
        stops.add(" from ");
        stops.add(" further ");
        stops.add(" had ");
        stops.add(" hadn't ");
        stops.add(" has ");
        stops.add(" hasn't ");
        stops.add(" have ");
        stops.add(" haven't ");
        stops.add(" having ");
        stops.add(" he ");
        stops.add(" he'd ");
        stops.add(" he'll ");
        stops.add(" he's ");
        stops.add(" her ");
        stops.add(" here ");
        stops.add(" here's ");
        stops.add(" hers ");
        stops.add(" herself ");
        stops.add(" him ");
        stops.add(" himself ");
        stops.add(" his ");
        stops.add(" how ");
        stops.add(" how's ");
        stops.add(" i ");
        stops.add(" i'd ");
        stops.add(" i'll ");
        stops.add(" i'm ");
        stops.add(" i've ");
        stops.add(" if ");
        stops.add(" in ");
        stops.add(" into ");
        stops.add(" is ");
        stops.add(" isn't ");
        stops.add(" it ");
        stops.add(" it's ");
        stops.add(" its ");
        stops.add(" itself ");
        stops.add(" let's ");
        stops.add(" me ");
        stops.add(" more ");
        stops.add(" most ");
        stops.add(" mustn't ");
        stops.add(" my ");
        stops.add(" myself ");
        stops.add(" no ");
        stops.add(" nor ");
        stops.add(" not ");
        stops.add(" of ");
        stops.add(" off ");
        stops.add(" on ");
        stops.add(" once ");
        stops.add(" only ");
        stops.add(" or ");
        stops.add(" other ");
        stops.add(" ought ");
        stops.add(" our ");
        stops.add(" ours ");
        stops.add(" ourselves ");
        stops.add(" out ");
        stops.add(" over ");
        stops.add(" own ");
        stops.add(" same ");
        stops.add(" shan't ");
        stops.add(" she ");
        stops.add(" she'd ");
        stops.add(" she'll ");
        stops.add(" she's ");
        stops.add(" should ");
        stops.add(" shouldn't ");
        stops.add(" so ");
        stops.add(" some ");
        stops.add(" such ");
        stops.add(" than ");
        stops.add(" that ");
        stops.add(" that's ");
        stops.add(" the ");
        stops.add(" their ");
        stops.add(" theirs ");
        stops.add(" them ");
        stops.add(" themselves ");
        stops.add(" then ");
        stops.add(" there ");
        stops.add(" there's ");
        stops.add(" these ");
        stops.add(" they ");
        stops.add(" they'd ");
        stops.add(" they'll ");
        stops.add(" they're ");
        stops.add(" they've ");
        stops.add(" this ");
        stops.add(" those ");
        stops.add(" through ");
        stops.add(" to ");
        stops.add(" too ");
        stops.add(" under ");
        stops.add(" until ");
        stops.add(" up ");
        stops.add(" very ");
        stops.add(" was ");
        stops.add(" wasn't ");
        stops.add(" we ");
        stops.add(" we'd ");
        stops.add(" we'll ");
        stops.add(" we're ");
        stops.add(" we've ");
        stops.add(" were ");
        stops.add(" weren't ");
        stops.add(" what ");
        stops.add(" what's ");
        stops.add(" when ");
        stops.add(" when's ");
        stops.add(" where ");
        stops.add(" where's ");
        stops.add(" which ");
        stops.add(" while ");
        stops.add(" who ");
        stops.add(" who's ");
        stops.add(" whom ");
        stops.add(" why ");
        stops.add(" why's ");
        stops.add(" with ");
        stops.add(" won't ");
        stops.add(" would ");
        stops.add(" wouldn't ");
        stops.add(" you ");
        stops.add(" you'd ");
        stops.add(" you'll ");
        stops.add(" you're ");
        stops.add(" you've ");
        stops.add(" your ");
        stops.add(" yours ");
        stops.add(" yourself ");
        stops.add(" yourselves ");

        text = text.toLowerCase();
        text = text.replace("\n", " ");
        text = text.replace("”", "");
        text = text.replace("’", "");
        text = text.replace("“", "");
        text = text.replace("‘", "");
        text = text.replace(" , ", "");
        text = text.replace(" . ", "");
        text = text.replace(" ; ", "");
        text = text.replace(" : ", "");
        text = text.replace(" ? ", "");
        text = text.replace(" & ", "");
        text = text.replace(" * ", "");
        text = text.replace(" - ", " ");
        text = text.replace(" ! ", "");
        text = text.replace(" ) ", "");
        text = text.replace(" ( ", "");
        text = text.replace("  ", " ");

        for (String stop : stops) {
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
            if (bigger.length() > 1) {
                System.out.println((++i) + ": " + bigger + " - " + calculatedsMap.get(bigger));
            }
            calculatedsMap.remove(bigger);
            bigger = calculatedsMap.firstKey();
        }

    }

    public static void extractReferences(String text){
        int indexReferences = text.lastIndexOf("References");
        if (indexReferences > 0) {
            String references = text.substring(indexReferences);
            String[] reference = references.split("\n");
            for (String r : reference) {
                if (r.length() > 3){
                    System.out.println(r);
                }
            }
        }
    }

    public static void extractAuthor(String text){

    }

    public static void extracObjective(String text){
        int indexObjective = text.indexOf("")
    }

    public static void main(String[] args) {

        PDDocument pd;
        try {
            File input = new File("pdf/1.pdf");  // The PDF file from where you would like to extract
            pd = PDDocument.load(input);
            int numberOfPages = pd.getNumberOfPages();

            PDFTextStripper stripper = new PDFTextStripper();
            String fullText = stripper.getText(pd);
            //System.out.println(text);
            String textOutStop = removeStopWords(fullText);
            String textOutStopOutReferences = textOutStop.substring(0, textOutStop.lastIndexOf("references"));
            //findMoreCiteds(textOutStopOutReferences);

            //extractReferences(text);

            stripper.setEndPage(3);
            String startText = stripper.getText(pd);
            extracObjective(startText);
            pd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
