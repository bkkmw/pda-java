# pda-java

### Day 02
- 객체 : Person, Phone, Store
- 객체 관계
  ```mermaid
  classDiagram
  class Person {
    String name
  }
  class Store {
    List phoneStock
    Phone providePhone(deviceModel, language)
  }
  class Phone {
    String language
    String deviceModel
    turnOn()
  }
  class SamsungPhone {
    turnOn()
  }
  class ApplePhone {
    turnOn()
  }
  class Customer {
    String language
    Phone phone
    purchasePhone(Store, deviceModel)
    turnOnPhone()

  }
  Phone <|-- SamsungPhone
  Phone <|-- ApplePhone
  Person <|-- Customer
  Store o-- Phone
  Customer o-- Phone
  ```
