package org.fundaciobit.powertoys.logic.compiladornocturn;

import org.fundaciobit.powertoys.model.entity.Compilacio;

public class CompilacioGitHub {

	private GitHubManager gitHubManager;

	public GitHubManager getGitHubManager() {
		return gitHubManager;
	}

	public void setGitHubManager(GitHubManager gitHubManager) {
		this.gitHubManager = gitHubManager;
	}

	private String gitUrl;

	public String getGitUrl() {
		return gitUrl;
	}

	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}

	private Compilacio compilacio;

	public Compilacio getCompilacio() {
		return compilacio;
	}

	public void setCompilacio(Compilacio compilacio) {
		this.compilacio = compilacio;
	}

	private String repoCompilacioNom;

	public String getRepoCompilacioNom() {
		return repoCompilacioNom;
	}

	public void setRepoCompilacioNom(String repoCompilacioNom) {
		this.repoCompilacioNom = repoCompilacioNom;
	}

	public CompilacioGitHub() {
	}

	public CompilacioGitHub(GitHubManager gitHubManager, String gitUrl, Compilacio compilacio,
			String repoCompilacioNom) {
		this.gitHubManager = gitHubManager;
		this.gitUrl = gitUrl;
		this.compilacio = compilacio;
		this.repoCompilacioNom = repoCompilacioNom;
	}

}
