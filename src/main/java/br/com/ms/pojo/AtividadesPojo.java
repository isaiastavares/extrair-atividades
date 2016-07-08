package br.com.ms.pojo;

import java.util.Date;

public class AtividadesPojo {

	private Integer sequencialAtividade;
	private String descricaoAtividade;
	private Float qtdeHorasAtividade;
	private Date dtInicioAtividade;
	private Date dtFimAtividade;

	public Integer getSequencialAtividade() {
		return sequencialAtividade;
	}

	public void setSequencialAtividade(Integer sequencialAtividade) {
		this.sequencialAtividade = sequencialAtividade;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public Float getQtdeHorasAtividade() {
		return qtdeHorasAtividade;
	}

	public void setQtdeHorasAtividade(Float qtdeHorasAtividade) {
		this.qtdeHorasAtividade = qtdeHorasAtividade;
	}

	public Date getDtInicioAtividade() {
		return dtInicioAtividade;
	}

	public void setDtInicioAtividade(Date dtInicioAtividade) {
		this.dtInicioAtividade = dtInicioAtividade;
	}

	public Date getDtFimAtividade() {
		return dtFimAtividade;
	}

	public void setDtFimAtividade(Date dtFimAtividade) {
		this.dtFimAtividade = dtFimAtividade;
	}
}