//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.26 at 04:01:23 PM BST 
//


package lineup.util.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MainConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MainConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="levels" type="{http://lineup/util/config}LevelList"/>
 *         &lt;element name="creeps" type="{http://lineup/util/config}CreepList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MainConfig", propOrder = {
    "levels",
    "creeps"
})
public class MainConfig {

    @XmlElement(required = true)
    protected LevelList levels;
    @XmlElement(required = true)
    protected CreepList creeps;

    /**
     * Gets the value of the levels property.
     * 
     * @return
     *     possible object is
     *     {@link LevelList }
     *     
     */
    public LevelList getLevels() {
        return levels;
    }

    /**
     * Sets the value of the levels property.
     * 
     * @param value
     *     allowed object is
     *     {@link LevelList }
     *     
     */
    public void setLevels(LevelList value) {
        this.levels = value;
    }

    /**
     * Gets the value of the creeps property.
     * 
     * @return
     *     possible object is
     *     {@link CreepList }
     *     
     */
    public CreepList getCreeps() {
        return creeps;
    }

    /**
     * Sets the value of the creeps property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreepList }
     *     
     */
    public void setCreeps(CreepList value) {
        this.creeps = value;
    }

}
