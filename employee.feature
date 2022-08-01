Feature: Data posting to Confluent Kafka queues.

  @SMOKE
  Scenario: 1) Check the status of RFID event detection service
    Given To check RFID event detection service is up and running

    Then Validate the status of event detection service
      | status  |
      | Running |

  @SMOKE
  Scenario: 2) Get the events from RFID readers and push it to kafka
    Given Read the EPC details from RFID readers and publishing to Kafka topic
      | event           | id                                   | epc                      | location | aisle | direction | store | readerId | origin |
      | rfid_Store_Exit | de305d54-75b4-431b-adb2-eb6b9e546014 | 3039ECBC012F26012A05FEDA | Exit5    | 2     | OUT       | 1388  | 1388     | Nedap  |

    Then Validate the orders published to Kafka
      | status  | message                                      |
      | Success | Event Received and Kafka process in progress |
    Then check the event pushed to kafka
      | epc                      |
      | 3039ECBC012F26012A05FEDA |

  @REGRESSION
  Scenario: 3) Validate when the empty EPC Event read by RFID readers
    Given Read the EPC details from RFID readers with empty EPC
      | event           | id                                   | epc | location | aisle | direction | store | readerId | origin |
      | rfid_Store_Exit | de305d54-75b4-431b-adb2-eb6b9e546014 |     | Exit5    | 2     | OUT       | 1388  | 1388     | Nedap  |

    Then Validate the response
      | status  | message                                      |
      | Success | Event Received and Kafka process in progress |
    Then check the event pushed to the kafka
      | epc |
      |     |

  @REGRESSION
  Scenario: 4) Validate when the invalid EPC Event read by RFID readers
    Given Read the EPC details from RFID readers with invalid EPC
      | event           | id                                   | epc        | location | aisle | direction | store | readerId | origin |
      | rfid_Store_Exit | de305d54-75b4-431b-adb2-eb6b9e546014 | invalidEPC | Exit5    | 2     | OUT       | 1388  | 1388     | Nedap  |

    Then Validate the response
      | status  | message                                      |
      | Success | Event Received and Kafka process in progress |
    Then check the event pushed to the kafka with invalid EPC
      | epc        |
      | invalidEPC|
