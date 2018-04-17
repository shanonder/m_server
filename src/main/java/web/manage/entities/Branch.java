package web.manage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String folder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    private String deSvn;

    private String artSvn;

    private String codeSvn;

    private String version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeSvn() {
        return deSvn;
    }

    public void setDeSvn(String deSvn) {
        this.deSvn = deSvn;
    }

    public String getArtSvn() {
        return artSvn;
    }

    public void setArtSvn(String artSvn) {
        this.artSvn = artSvn;
    }

    public String getCodeSvn() {
        return codeSvn;
    }

    public void setCodeSvn(String codeSvn) {
        this.codeSvn = codeSvn;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
