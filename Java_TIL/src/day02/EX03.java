package day02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EX03 {
    public static void main(String[] args) {

        List<Phone> phones = new ArrayList<Phone>();
        // add 2
        for(int i=0; i<2; i++) {
            String deviceId = "samsung" + i;
            phones.add(new SamsungPhone(deviceId, "samsung"));
            phones.add(new ApplePhone(deviceId, "apple"));
        }

        Store store = new Store(phones);

        Customer son = new Customer("쏘니", "kr");
        Customer beckam = new Customer("베컴", "eng");

        son.purchasePhone(store, "samsung");
        beckam.purchasePhone(store, "apple");

        son.turnOnPhone();
        beckam.turnOnPhone();

    }
}

class Store {
    private List<Phone> phoneStock;

    Store(List<Phone> phones) {
        this.phoneStock = phones;
    }

    Phone providePhone(String deviceModel, String language) {
        Iterator<Phone> it = phoneStock.iterator();
        Phone ret = null;

        while (it.hasNext()) {
            Phone phone = it.next();
            if (phone.deviceModel.equals(deviceModel)) {
                phone.setLanguage(language);
                ret = phone;
                break;
            }
        }

        phoneStock.remove(ret);

        return ret;
    }

}

class Person {
    protected String name;

    Person(String name) {
        this.name = name;
    }
}


class Customer extends Person {
    private String language;
    private Phone phone;

    Customer(String name, String language) {
        super(name);
        this.language = language;
    }

    void purchasePhone(Store store, String deviceModel) {
        Phone phone = store.providePhone(deviceModel, this.language);
        if(phone != null) {
            this.phone = phone;
        }
    }

    void turnOnPhone() {
        if("kr".equals(this.language)) {
            System.out.println(this.name + " : 야 내 핸드폰 켜볼게");
        } else if("eng".equals(this.language)) {
            System.out.println(this.name + " : turn on");
        }

        this.phone.turnOn();
    }
}

class Phone {
    String deviceId;
    String deviceModel;
    String language = "eng";
    String[] providedLanguages = new String[] {"eng", "kr"};

    Phone(String deviceId, String deviceModel) {
        this.deviceId = deviceId;
        this.deviceModel = deviceModel;
    }

    void setLanguage(String language) {
        for(int i=0; i<providedLanguages.length; i++) {
            if (providedLanguages[i].equals(language)) {
                this.language = language;
                break;
            }
        }
    }

    void turnOn() {
        if("eng".equals(this.language)) {
            System.out.println("bbeep");
        } else if("kr".equals(this.language)) {
            System.out.println("삐비빅");
        }
    }
}

class SamsungPhone extends Phone {

    SamsungPhone(String deviceId, String deviceModel) {
        super(deviceId, deviceModel);
    }

    void turnOn() {
        System.out.println("Starting Apple phone");
    }
}

class ApplePhone extends Phone {

    ApplePhone(String deviceId, String deviceModel) {
        super(deviceId, deviceModel);
    }

    void turnOn() {
        System.out.println("Starting Samsung galaxy");
    }
}