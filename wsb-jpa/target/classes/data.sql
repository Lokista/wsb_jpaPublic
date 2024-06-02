-- Insert statements for the ADDRESS table
INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
VALUES
    (1, 'Ul. Klonowa', 'room5', 'Poznan', '11111'),
    (2, 'Ul. Lipowa', 'room 2', 'Krakow', '67890'),
    (3, 'Ul. Brzozowa', 'room7', 'Warszwa', '98765'),
    (4, 'Ul. Świerkowa', 'room 3', 'Wroclaw', '55555');

-- Insert statements for the DOCTOR table
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, specialization, doctor_number, address_id)
VALUES
    (1, 'Jan', 'Kowalski', '234567890', 'jankowalski@gmeil.com', 'SURGEON', 'D005', 1),
    (2, 'Anna', 'Nowak', '876543210', 'annanowak@gmeil.com', 'DERMATOLOGIST', 'D006', 2),
    (3, 'Robert', 'Wiśniewski', '567890123', 'robertwisniewski@gmeil.com', 'OCULIST', 'D007', 3),
    (4, 'Maria', 'Kaczmarek', '345678901', 'mariakaczmarek@gmeil.com', 'DENTIST', 'D008', 4);

-- Insert statements for the PATIENT table
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, patient_history)
VALUES
    (1, 'Marek', 'Nowak', '432109876', 'marek.nowak@przyklad.com', 'P2001', '1978-03-14', 'cukrzyca'),
    (2, 'Katarzyna', 'Liu', '543210987', 'katarzyna.liu@przyklad.com', 'P2002', '1982-06-23', 'alergie'),
    (3, 'Tomasz', 'Hanks', '654321098', 'tomasz.hanks@przyklad.com', 'P2003', '1995-08-19', 'astma'),
    (4, 'Julia', 'Roberts', '765432109', 'julia.roberts@przyklad.com', 'P2004', '1980-02-11', 'nadciśnienie');

-- Insert statements for the VISIT table
INSERT INTO VISIT (id, description, time, doctor_id, patient_id)
VALUES
    (1, 'Czyszczenie zębów', '2024-05-20 10:00:00', 1, 1),
    (2, 'Badanie wzroku', '2024-05-21 11:00:00', 2, 2),
    (3, 'Sesja fizjoterapeutyczna', '2024-05-22 14:00:00', 3, 3),
    (4, 'Konsultacja kardiologiczna', '2024-05-23 09:00:00', 4, 4);

-- Insert statements for the MEDICAL_TREATMENT table
INSERT INTO MEDICAL_TREATMENT (id, description, visit_id)
VALUES
    (1, 'Czyszczenie zębów', 1),
    (2, 'Test wzroku', 2),
    (3, 'Fizjoterapia', 3),
    (4, 'EKG', 4);
