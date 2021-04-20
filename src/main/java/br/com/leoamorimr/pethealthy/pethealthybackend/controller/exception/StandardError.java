package br.com.leoamorimr.pethealthy.pethealthybackend.controller.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String msg;
	private Long timesTamp;

	/**
	 * @param status
	 * @param msg
	 * @param timesTamp
	 */
	public StandardError(Integer status, String msg, Long timesTamp) {
		this.status = status;
		this.msg = msg;
		this.timesTamp = timesTamp;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the timesTamp
	 */
	public Long getTimesTamp() {
		return timesTamp;
	}

	/**
	 * @param timesTamp the timesTamp to set
	 */
	public void setTimesTamp(Long timesTamp) {
		this.timesTamp = timesTamp;
	}

}
