package it.polito.tdp.nyc.model;

public class Arco implements Comparable<Arco>{
	
	private String NTACode1;
	private String NTACode2;
	private Integer peso;
	
	public Arco(String nTACode1, String nTACode2, Integer peso) {
		super();
		NTACode1 = nTACode1;
		NTACode2 = nTACode2;
		this.peso = peso;
	}

	public String getNTACode1() {
		return NTACode1;
	}

	public void setNTACode1(String nTACode1) {
		NTACode1 = nTACode1;
	}

	public String getNTACode2() {
		return NTACode2;
	}

	public void setNTACode2(String nTACode2) {
		NTACode2 = nTACode2;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "NTACode1=" + NTACode1 + ", NTACode2=" + NTACode2 + ", peso=" + peso;
	}

	@Override
	public int compareTo(Arco o) {
		return o.peso-peso;
	}
	
	
	
	
	
	
	



}
