/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author BangsJack
 */
@Entity 
@Table(name="t_pengguna",
        uniqueConstraints = {@UniqueConstraint(columnNames={"user_id"})}
        )
public class Pengguna {
    @Id 
    @GeneratedValue
    @Column(name="kode_pengguna", length=3)
    private Long id;
    
    @Column(name="user_id", length=20, nullable=false)
    private String userId;
    
    @Column(name="pass_id", length=20, nullable=false)
    private String passId;
    
    @Column(name="nama", length=60, nullable=false)
    private String nama;
    
    @Column(name="level_pengguna", length=10, nullable=false)
    private String levelPengguna;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLevelPengguna() {
        return levelPengguna;
    }

    public void setLevelPengguna(String levelPengguna) {
        this.levelPengguna = levelPengguna;
    }    
}
