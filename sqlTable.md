# Hospital Management System - SQL Tables

## Patients
```sql
CREATE TABLE Patients (
    PatientID INT PRIMARY KEY,
    Name VARCHAR
    Age
    Gender VARCHAR(10),
);
```

## Doctors
```sql
CREATE TABLE Doctors (
    DoctorID INT PRIMARY KEY,
    Name
    Specialization
);
```

## Appointments
```sql
CREATE TABLE Appointments (
    AppointmentID INT PRIMARY KEY,
    PatientID INT,
    DoctorID INT,
    AppointmentDate DATETIME,
    Status VARCHAR(20),
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
);
```



