/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mlr_rest;

/**
 *
 * @author krishna
 */
public class MLR_Message {

    private int id;
    private String message;
    private String uid;
    private String itemid;
    private String rating;

    public MLR_Message(int id, String uid, String itemid, String rating) {
        this.id = id;
        this.uid = uid;
        this.itemid = itemid;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Message{ id:" + id + ",uid: " + uid + ",itemid:" + itemid + ",rating:" + rating + "}";
    }
}
