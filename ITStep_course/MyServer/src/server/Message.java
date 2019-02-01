package server;

import java.io.Serializable;

public class Message implements Serializable {

    final public byte LOGIN = 1;
    final public byte DBSELECT = 2;
    final public byte DBUPDATE = 3;
    final public byte DBINSERT = 4;
    final public byte SUCCESS = 5;
    final public byte FAILURE = 6;
    final public byte REQUEST = 7;
    final public byte BYE = 8;

    private final byte type;
    private final byte response;
    private final String user;
    private final String text;

    public Message(byte type, byte response, String user, String text) {
        this.type = type;
        this.response = response;
        this.user = user;
        this.text = text;
    }

    /*
	public void setType(byte type){
		this.type = type;
	}
	public void setresponse(byte response){
		this.response = response;
	}
	public void setuser(String user){
		this.user = user;
	}
	public void setText(String text){
		this.text = text
	}
     */
    /**
     * Defines what do we want server to do
     *
     * @return the type of the message
     */
    public byte getType() {
        return this.type;
    }

    /**
     * Returns if the requested operation suceeded or failed
     *
     * @return succes or failure
     */
    public byte getResponse() {
        return this.response;
    }

    /**
     * User who requested operation
     *
     * @return string user
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Additional information or request / response parameters
     *
     * @return
     */
    public String getText() {
        return this.text;
    }

}
