import java.util.ArrayList;
import java.util.List;

/**
 * Created by joao on 8/31/15.
 */
public class Util {

    public static List<String> getStopWords(){
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

        return stops;
    }

    public static List<String> getTopicsAfterReferences(){
        List<String> topics = new ArrayList<>();

        topics.add("Further reading\n");
        topics.add("About the authors\n");
        topics.add("Reports\n");
        topics.add("Author\n");
        topics.add("Citação da fonte ");

        return topics;
    }

    public static List<String> getNamesToAuthor(){
        List<String> names = new ArrayList<>();

        names.add("department");
        names.add("university");
        names.add("associate");
        names.add("centre");
        names.add("laboratory");
        names.add("université");
        names.add("college");
        names.add("group");
        names.add("school");
        names.add("institute");
        names.add("politecnico");
        names.add("universidad");
        names.add("foundation");
        names.add("departamento");

        return names;
    }

}
