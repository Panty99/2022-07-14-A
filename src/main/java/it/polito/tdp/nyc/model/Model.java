package it.polito.tdp.nyc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.nyc.db.NYCDao;

public class Model {
	
	private NYCDao dao;
	private Graph<String, DefaultWeightedEdge> grafo;
	private Map<Integer, String> ntaIDMap;
	
	public Model() {
		
		this.dao = new NYCDao();
		this.ntaIDMap = new HashMap<>();
	}
	
	public List<String> getBorgo(){
		return dao.getAllBorgo();
	}
	
	public void creaGrafo(String borgo) {
		
		grafo = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(grafo, dao.getVertici(borgo));
		
		List<Arco> archi = this.dao.getArchi(borgo);
		for(Arco a: archi) {
			Graphs.addEdgeWithVertices(grafo, a.getNTACode1(), a.getNTACode2(), a.getPeso());
		}
	}
	
	public List<String> listVertici(){
		List<String> vertici = new ArrayList<>(this.grafo.vertexSet());
		return vertici;
	}
	
	public List<Arco> listArchi(){
		List<Arco> archi = new ArrayList<>();
		for(DefaultWeightedEdge e: this.grafo.edgeSet()) {
			archi.add(new Arco(grafo.getEdgeSource(e),grafo.getEdgeTarget(e),(int)grafo.getEdgeWeight(e)));
		}
		return archi;
	}
	
	public List<Arco> analisi(){
		
		List<Arco> archi = listArchi();
		Double avg = 0.0;
		int sum = 0;
		int i = 0;
		for(Arco a: archi) {
			sum += a.getPeso();
			i++;
		}
		avg = (double) (sum/i);
		
		List<Arco> archiAnalizzati = new ArrayList<>();
		for(Arco a: archi) {
			if(a.getPeso()>avg) {
				archiAnalizzati.add(a);
			}
		}
		Collections.sort(archiAnalizzati);
		return archiAnalizzati;
		
	}
	
//    public Double pesoMedio(){
//		
//		List<Arco> archi = listArchi();
//		double avg = 0;
//		int sum = 0;
//		int i = 0;
//		for(Arco a: archi) {
//			sum += a.getPeso();
//			i++;
//		}
//		avg = sum/i;
//		
//		List<Arco> archiAnalizzati = new ArrayList<>();
//		for(Arco a: archi) {
//			if(a.getPeso()>avg) {
//				archiAnalizzati.add(a);
//			}
//		}
//		Collections.sort(archiAnalizzati);
//		return archiAnalizzati;
//		
//	}
	
}
