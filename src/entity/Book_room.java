/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DELL
 */
public class Book_room {

    private int id;
    private int book_id;
    private int room_id;

    public Book_room(int id, int book_id, int room_id) {
        this.id = id;
        this.book_id = book_id;
        this.room_id = room_id;
    }

    public Book_room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "Book_room{" + "id=" + id + ", book_id=" + book_id + ", room_id=" + room_id + '}';
    }
    
}
