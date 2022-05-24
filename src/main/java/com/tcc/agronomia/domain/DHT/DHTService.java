package com.tcc.agronomia.domain.DHT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class DHTService {

    @Autowired
    private DHTRepository rep;

    public Iterable<ArduinoDHT> getDHTDados() {
        return rep.findAll();
    }

    public Optional<ArduinoDHT> getDHTById(long id) {
        return rep.findById(id);
    }

    public ArduinoDHT insert(ArduinoDHT arduino) {
        return rep.save(arduino);
    }

    public ArduinoDHT update(ArduinoDHT arduino, long id) {
        Assert.notNull(getDHTById(id), "Não foi possivel atualizar o registro!");

        Optional<ArduinoDHT> arduinoDHT = getDHTById(id);
        if(arduinoDHT.isPresent()){
            ArduinoDHT db = arduinoDHT.get();
            db.setIdArduino(arduino.getIdArduino());
            db.setNome(arduino.getNome());

            System.out.println("Dados sensor DHT atualizado com sucesso! "+db.getId());

            rep.save(db);

            return db;
        }else{
            throw new RuntimeException("Não foi possivel atualizar o registro!");
        }
    }

    public String delete(long id) {
        Optional<ArduinoDHT> dht = getDHTById(id);
        if(dht.isPresent()){
            rep.delete(dht.get());
            return "Registro deletado com sucesso: "+dht.get().getId();
        }else{
            throw new RuntimeException("Não foi possivel deletar o registro");
        }
    }
}
