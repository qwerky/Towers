//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.26 at 04:01:23 PM BST 
//


package lineup.util.config;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lineup.util.config package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MainConfig_QNAME = new QName("http://lineup/util/config", "mainConfig");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lineup.util.config
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Route }
     * 
     */
    public Route createRoute() {
        return new Route();
    }

    /**
     * Create an instance of {@link MainConfig }
     * 
     */
    public MainConfig createMainConfig() {
        return new MainConfig();
    }

    /**
     * Create an instance of {@link CreepConfig }
     * 
     */
    public CreepConfig createCreepConfig() {
        return new CreepConfig();
    }

    /**
     * Create an instance of {@link LevelConfig }
     * 
     */
    public LevelConfig createLevelConfig() {
        return new LevelConfig();
    }

    /**
     * Create an instance of {@link LevelList }
     * 
     */
    public LevelList createLevelList() {
        return new LevelList();
    }

    /**
     * Create an instance of {@link Waypoint }
     * 
     */
    public Waypoint createWaypoint() {
        return new Waypoint();
    }

    /**
     * Create an instance of {@link WaveList }
     * 
     */
    public WaveList createWaveList() {
        return new WaveList();
    }

    /**
     * Create an instance of {@link WaveConfig }
     * 
     */
    public WaveConfig createWaveConfig() {
        return new WaveConfig();
    }

    /**
     * Create an instance of {@link CreepList }
     * 
     */
    public CreepList createCreepList() {
        return new CreepList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MainConfig }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lineup/util/config", name = "mainConfig")
    public JAXBElement<MainConfig> createMainConfig(MainConfig value) {
        return new JAXBElement<MainConfig>(_MainConfig_QNAME, MainConfig.class, null, value);
    }

}
