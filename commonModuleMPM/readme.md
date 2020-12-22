This project provides an example implementation of MPM 

# Terms
- eGK = elektronische Gesundheitskarte = insurance card
- Wawi = WAWI = computer system of pharmacy
- BMP = Bundesmedikationsplan, medication plan printed and scanned
- EMP = electronic medication plan, medication plan saved on the eGK
- AMTSCheck = check of interactions
- Medical profession = Heilberuf  
- casual customer = Customer who is not a known customer

# Use Cases
- Pharmacy staff scans the medication plan in case of non emp.
- Pharmacy system creates new medication plan by reading it from eGK or new empty medication plan in case of emp
- Pharmacy system includes data from medication plan in AMTS check of Wawi (PZNs) 
- Pharmacy system shows existing medication plan
- Pharmacy must interpret the data of barcode
- Pharmacy staff prints the medication plan, which can be 1-3 pages long in case of non emp.
- Pharmacy staff can upload an emp to card again in case of emp   
- The Wawi must delete medication plans and data of BMP daily for casual customers.
- MPM reads the data of assured person from his eGK
- MPM visualizes the data of assured person
- MPM can synchronize data of assured person to Wawi
- MPM can show emergency dataset of assured person
- MPM can unlock ID card of medical profession person
- Pharmacy staff can compare medication plans and can clone data from old plan into new one.
- MPM can convert mpm to epm and vice versa (why?)
- Planansicht ????

# Open points
- TLS geht nicht - 
- Signieren fehlt
- Wo wird die Dauermedikation gespeichert?

emp (hat mehr Daten) und bmp müssen gegenseitig verwandelt

Wenn XML vorhanden ist, müssen Kundendaten und PZNs vom Infoserver geholt werden
Artikel mit Textinformationen werden andersfarbig angezeigt
Artikel hinzufügen über Abverkäufen der Wawi oder manuell durch Nachfrage am Infoserver 


# How to get a testsystem 

# How to bind this central module
