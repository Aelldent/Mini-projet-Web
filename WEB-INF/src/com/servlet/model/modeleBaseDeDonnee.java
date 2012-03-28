package com.servlet.model;

import javax.servlet.http.HttpServlet;

@SuppressWarnings("serial")
public class modeleBaseDeDonnee extends HttpServlet 
{
	private String nomArtiste;
	private String titreSoundtrack;
	private String Featuring;
	private String musicPlayer;
	private String audioEngineer;
	private String lyricsWriter;
	
	public modeleBaseDeDonnee()
	{
		
	}

	
	public String getNomArtiste() {
		return nomArtiste;
	}
	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}
	public String getTitreSoundtrack() {
		return titreSoundtrack;
	}
	public void setTitreSoundtrack(String titreSoundtrack) {
		this.titreSoundtrack = titreSoundtrack;
	}
	public String getFeaturing() {
		return Featuring;
	}
	public void setFeaturing(String featuring) {
		Featuring = featuring;
	}
	public String getMusicPlayer() {
		return musicPlayer;
	}
	public void setMusicPlayer(String musicPlayer) {
		this.musicPlayer = musicPlayer;
	}
	public String getAudioEngineer() {
		return audioEngineer;
	}
	public void setAudioEngineer(String audioEngineer) {
		this.audioEngineer = audioEngineer;
	}
	public String getLyricsWriter() {
		return lyricsWriter;
	}
	public void setLyricsWriter(String lyricsWriter) {
		this.lyricsWriter = lyricsWriter;
	}
	
	 
	

}
