package net.kigawa.plugin.kyosaba.system.bingosystem.data;

import java.util.List;

public class YamlUUIDs {
    List<String> uuid;
    public YamlUUIDs(List<String > uuid){
        this.uuid=uuid;
    }
    public List<String> getUuid(){
        return uuid;
    }
    public void setUuid(List<String> uuid){
        this.uuid=uuid;
    }
}

