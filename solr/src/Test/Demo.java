package Test;

import javax.xml.ws.Response;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class Demo {
	
	@Test
	public void demo() throws Exception{
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("content", "y44y");
		document.addField("id", "coo2");
		solrServer.add(document);
		solrServer.commit();
	}
	@Test
	public void demo1() throws Exception{
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/");
		solrServer.deleteById("coo1");
		solrServer.commit();
	}
	@Test
	public void demo2() throws Exception{
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/");
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
	@Test
	public void demo3() throws Exception{
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/");
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("*:*");
		QueryResponse queryResponse = solrServer.query(solrQuery);
		SolrDocumentList results = queryResponse.getResults();
		System.out.println(results.getNumFound());
		for (SolrDocument solrDocument : results) {
			
			System.out.println(solrDocument.get("id"));
		}
		solrServer.commit();
	}

}
