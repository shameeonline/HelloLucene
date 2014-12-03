package luceneautosuggester;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

import org.apache.lucene.search.spell.TermFreqIterator;
import org.apache.lucene.search.suggest.InputIterator;
import org.apache.lucene.util.BytesRef;

public final class WordFreqArrayIterator implements TermFreqIterator, InputIterator {
 private WordFreq current;
 private final Iterator<WordFreq> wordFreqIterator;

 public WordFreqArrayIterator(Iterator<WordFreq> wordFreqIterator) {
  this.wordFreqIterator = wordFreqIterator;
 }

 public WordFreqArrayIterator(WordFreq[] list) {
  this(Arrays.asList(list).iterator());
 }

 public Comparator<BytesRef> getComparator() {
  return null;
 }

 public BytesRef next() {
  if (wordFreqIterator.hasNext()) {
   current = wordFreqIterator.next();
   return current.term;
  }
  return null;
 }

 public long weight() {
  return current.count;
 }

public Set<BytesRef> contexts() {
	// TODO Auto-generated method stub
	return null;
}

public boolean hasContexts() {
	// TODO Auto-generated method stub
	return false;
}

public boolean hasPayloads() {
	// TODO Auto-generated method stub
	return false;
}

public BytesRef payload() {
	// TODO Auto-generated method stub
	return null;
}
}