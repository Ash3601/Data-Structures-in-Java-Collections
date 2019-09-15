// import java.util.HashSet;
import java.util.*;

class HashSetDelDup {
	// del duplicates using hashset method
	public static String[] removeDuplicates(String[] filenames) {
	    LinkedHashSet<String> uniqueFiles = new LinkedHashSet<String>();
        for(String filename: filenames)
            uniqueFiles.add(filename);
        return uniqueFiles.toArray(new String[0]);
	}

	public static void main(String args[]) {
		String[] dupNames = {"alice", "bob", "trudy", "bob", "alice"};
        for(String name: removeDuplicates(dupNames))
            System.out.println(name);
	}
}