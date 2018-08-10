/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.PreparedStatement;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohammad Reza
 */
@Entity
@Table(name = "tour_details", catalog = "busm", schema = "")
@NamedQueries({
    @NamedQuery(name = "TourDetails.findAll", query = "SELECT t FROM TourDetails t")
    , @NamedQuery(name = "TourDetails.findById", query = "SELECT t FROM TourDetails t WHERE t.id = :id")
    , @NamedQuery(name = "TourDetails.findByBusNo", query = "SELECT t FROM TourDetails t WHERE t.busNo = :busNo")
    , @NamedQuery(name = "TourDetails.findByBusSource", query = "SELECT t FROM TourDetails t WHERE t.busSource = :busSource")
    , @NamedQuery(name = "TourDetails.findByBusDest", query = "SELECT t FROM TourDetails t WHERE t.busDest = :busDest")
    , @NamedQuery(name = "TourDetails.findByDepartDate", query = "SELECT t FROM TourDetails t WHERE t.departDate = :departDate")
    , @NamedQuery(name = "TourDetails.findByDepartTime", query = "SELECT t FROM TourDetails t WHERE t.departTime = :departTime")
    , @NamedQuery(name = "TourDetails.findByPrice", query = "SELECT t FROM TourDetails t WHERE t.price = :price")
    , @NamedQuery(name = "TourDetails.findByTotalSeat", query = "SELECT t FROM TourDetails t WHERE t.totalSeat = :totalSeat")
    , @NamedQuery(name = "TourDetails.findByCorReserve", query = "SELECT t FROM TourDetails t WHERE t.corReserve = :corReserve")})
public class TourDetails implements Serializable {
    
    @Transient
    private PropertyChangeSupport changeSupport;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "bus_no")
    private String busNo;
    @Basic(optional = false)
    @Column(name = "bus_source")
    private String busSource;
    @Basic(optional = false)
    @Column(name = "bus_dest")
    private String busDest;
    @Basic(optional = false)
    @Column(name = "depart_date")
    private String departDate;
    @Basic(optional = false)
    @Column(name = "depart_time")
    private String departTime;
    @Basic(optional = false)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @Column(name = "total_seat")
    private String totalSeat;
    @Basic(optional = false)
    @Column(name = "corReserve")
    private String corReserve;
    @Basic(optional = false)
    @Column(name = "requestOfReserve")
    private String request;

    public TourDetails() {
        this.changeSupport = new PropertyChangeSupport(this);
    }

    public TourDetails(Integer id) {
        this.changeSupport = new PropertyChangeSupport(this);
        this.id = id;
    }

    public TourDetails(Integer id, String busNo, String busSource, String busDest, String departDate, String departTime, String price, String totalSeat, String corReserve
                       , String request) {
        this.changeSupport = new PropertyChangeSupport(this);
        this.id = id;
        this.busNo = busNo;
        this.busSource = busSource;
        this.busDest = busDest;
        this.departDate = departDate;
        this.departTime = departTime;
        this.price = price;
        this.totalSeat = totalSeat;
        this.corReserve = corReserve;
        this.request = request;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        String oldBusNo = this.busNo;
        this.busNo = busNo;
        changeSupport.firePropertyChange("busNo", oldBusNo, busNo);
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        String oldBusSource = this.busSource;
        this.busSource = busSource;
        changeSupport.firePropertyChange("busSource", oldBusSource, busSource);
    }

    public String getBusDest() {
        return busDest;
    }

    public void setBusDest(String busDest) {
        String oldBusDest = this.busDest;
        this.busDest = busDest;
        changeSupport.firePropertyChange("busDest", oldBusDest, busDest);
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        String oldDepartDate = this.departDate;
        this.departDate = departDate;
        changeSupport.firePropertyChange("departDate", oldDepartDate, departDate);
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        String oldDepartTime = this.departTime;
        this.departTime = departTime;
        changeSupport.firePropertyChange("departTime", oldDepartTime, departTime);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        String oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(String totalSeat) {
        String oldTotalSeat = this.totalSeat;
        this.totalSeat = totalSeat;
        changeSupport.firePropertyChange("totalSeat", oldTotalSeat, totalSeat);
    }

    public String getCorReserve() {
        return corReserve;
    }

    public void setCorReserve(String corReserve) {
        String oldCorReserve = this.corReserve;
        this.corReserve = corReserve;
        changeSupport.firePropertyChange("corReserve", oldCorReserve, corReserve);
    }
    
    public String getRequest(){
        return request;
    }
    
    public void setRequest(String request){
        String oldRequest = this.request;
        this.request = request;
        changeSupport.firePropertyChange("request", oldRequest, request);
    }
  
    //Main Methods
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourDetails)) {
            return false;
        }
        TourDetails other = (TourDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.TourDetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    } 
}
