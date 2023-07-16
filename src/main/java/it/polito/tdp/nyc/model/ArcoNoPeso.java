package it.polito.tdp.nyc.model;

public class ArcoNoPeso {
	
	private String NTACode1;
	private String NTACode2;
	
	public ArcoNoPeso(String nTACode1, String nTACode2) {
		super();
		NTACode1 = nTACode1;
		NTACode2 = nTACode2;
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

	@Override
	public String toString() {
		return "NTACode1=" + NTACode1 + ", NTACode2=" + NTACode2;
	}


}
