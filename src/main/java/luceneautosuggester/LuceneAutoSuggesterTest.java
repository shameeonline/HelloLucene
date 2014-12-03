package luceneautosuggester;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.suggest.Lookup.LookupResult;
import org.apache.lucene.search.suggest.analyzing.AnalyzingSuggester;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class LuceneAutoSuggesterTest {

 @Test
 public void luceneAutoSuggester() throws IOException {
  WordFreq wordFreqs[] = new WordFreq[] { new WordFreq("ball", 50),
    new WordFreq("bar", 10), new WordFreq("ba", 12),
    new WordFreq("ballon", 6) };

  AnalyzingSuggester suggester = new AnalyzingSuggester(
    new StandardAnalyzer(Version.LUCENE_40));

  suggester.build(new WordFreqArrayIterator(wordFreqs));

  List<LookupResult> results = suggester.lookup("ba", false, 100);

  System.out.println("Suggested words for input \"ba\"");
  for (LookupResult lookupResult : results) {
   System.out.println(lookupResult.key + ":" + lookupResult.value);
  }
 }
}