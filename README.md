# Debezium-Postgres-Camel-Extension

Welcome to the magical land of database change data capture (CDC), where we take the mundane task of tracking Postgres changes and make it as entertaining as binge-watching cat videos. This repository contains an extension of the Debezium Postgres Connector, cleverly designed to make your data pipelines run smoother than your morning coffee.

## What's in the Box?

This project extends the Debezium Postgres Connector using Apache Camel, enabling you to effortlessly capture database changes, log them with style, and do it all with a smirk on your face.

## Pre-requisites

Before you dive into this wild ride, make sure you have the following:

- **Java 21+**: Because we're fancy like that.
- **Apache Maven 3.8.8**: To build and package your dreams.
- **PostgreSQL 16**: The trusty old friend that we're listening to.
- **Quarkus**: Because we like things fast and lean.

## How to Get Started

1. **Clone the Repo**:
```
git clone https://github.com/rajat965ng/debezium-postgres-camel-extension.git

cd debezium-postgres-camel-extension
```

2. **Compile the Code**:
```
mvn clean install
```
If everything works fine, you'll be rewarded with a freshly baked jar file in the target directory.

3. **Run the Application**:
```
java -jar target/quarkus-app/quarkus-run.jar
```
Sit back, relax, and watch as your database changes get logged like they're in a reality TV show.

## JSON Output

```json lines
2024-09-03 13:56:37,602 INFO  [FromPostgres] (Camel (camel-1) thread #1 - DebeziumConsumer) Event received from Postgres: {"schema":{"type":"STRUCT","optional":true,"fields":[{"name":"emp_no","index":0,"schema":{"type":"INT32","optional":false,"defaultValue":0}},{"name":"birth_date","index":1,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}},{"name":"first_name","index":2,"schema":{"type":"STRING","optional":false}},{"name":"last_name","index":3,"schema":{"type":"STRING","optional":false}},{"name":"gender","index":4,"schema":{"type":"STRING","optional":false}},{"name":"hire_date","index":5,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}}],"fieldsByName":{"last_name":{"name":"last_name","index":3,"schema":{"type":"STRING","optional":false}},"hire_date":{"name":"hire_date","index":5,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}},"gender":{"name":"gender","index":4,"schema":{"type":"STRING","optional":false}},"emp_no":{"name":"emp_no","index":0,"schema":{"type":"INT32","optional":false,"defaultValue":0}},"first_name":{"name":"first_name","index":2,"schema":{"type":"STRING","optional":false}},"birth_date":{"name":"birth_date","index":1,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}}},"name":"console.public.employee.Value"},"values":[12001,7213,"SR","K","M",7214]}
2024-09-03 13:56:37,603 INFO  [FromPostgres] (Camel (camel-1) thread #1 - DebeziumConsumer)     with metadata: {CamelDebeziumBefore=null, CamelDebeziumDdlSQL=null, CamelDebeziumIdentifier=console.public.employee, CamelDebeziumKey=Struct{emp_no=12001}, CamelDebeziumOperation=c, CamelDebeziumSourceMetadata={schema=public, xmin=null, ts_us=1725351997015197, lsn=29131992, txId=806, version=2.7.1.Final, sequence=["29131936","29131992"], connector=postgresql, name=console, ts_ns=1725351997015197000, ts_ms=1725351997015, snapshot=false, db=employee, table=employee}, CamelDebeziumTimestamp=1725351997226, CamelMessageTimestamp=1725351997226, Content-Type=application/json}
2024-09-03 13:56:37,603 INFO  [FromPostgres] (Camel (camel-1) thread #1 - DebeziumConsumer) INSERT: {"schema":{"type":"STRUCT","optional":true,"fields":[{"name":"emp_no","index":0,"schema":{"type":"INT32","optional":false,"defaultValue":0}},{"name":"birth_date","index":1,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}},{"name":"first_name","index":2,"schema":{"type":"STRING","optional":false}},{"name":"last_name","index":3,"schema":{"type":"STRING","optional":false}},{"name":"gender","index":4,"schema":{"type":"STRING","optional":false}},{"name":"hire_date","index":5,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}}],"fieldsByName":{"last_name":{"name":"last_name","index":3,"schema":{"type":"STRING","optional":false}},"hire_date":{"name":"hire_date","index":5,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}},"gender":{"name":"gender","index":4,"schema":{"type":"STRING","optional":false}},"emp_no":{"name":"emp_no","index":0,"schema":{"type":"INT32","optional":false,"defaultValue":0}},"first_name":{"name":"first_name","index":2,"schema":{"type":"STRING","optional":false}},"birth_date":{"name":"birth_date","index":1,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}}},"name":"console.public.employee.Value"},"values":[12001,7213,"SR","K","M",7214]}
2024-09-03 13:56:45,184 INFO  [FromPostgres] (Camel (camel-1) thread #1 - DebeziumConsumer) Event received from Postgres: {"schema":{"type":"STRUCT","optional":true,"fields":[{"name":"emp_no","index":0,"schema":{"type":"INT32","optional":false,"defaultValue":0}},{"name":"birth_date","index":1,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}},{"name":"first_name","index":2,"schema":{"type":"STRING","optional":false}},{"name":"last_name","index":3,"schema":{"type":"STRING","optional":false}},{"name":"gender","index":4,"schema":{"type":"STRING","optional":false}},{"name":"hire_date","index":5,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}}],"fieldsByName":{"last_name":{"name":"last_name","index":3,"schema":{"type":"STRING","optional":false}},"hire_date":{"name":"hire_date","index":5,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}},"gender":{"name":"gender","index":4,"schema":{"type":"STRING","optional":false}},"emp_no":{"name":"emp_no","index":0,"schema":{"type":"INT32","optional":false,"defaultValue":0}},"first_name":{"name":"first_name","index":2,"schema":{"type":"STRING","optional":false}},"birth_date":{"name":"birth_date","index":1,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}}},"name":"console.public.employee.Value"},"values":[12001,7213,"SR","K","F",7214]}
2024-09-03 13:56:45,186 INFO  [FromPostgres] (Camel (camel-1) thread #1 - DebeziumConsumer)     with metadata: {CamelDebeziumBefore=null, CamelDebeziumDdlSQL=null, CamelDebeziumIdentifier=console.public.employee, CamelDebeziumKey=Struct{emp_no=12001}, CamelDebeziumOperation=u, CamelDebeziumSourceMetadata={schema=public, xmin=null, ts_us=1725352004522681, lsn=29138120, txId=807, version=2.7.1.Final, sequence=["29138120","29138120"], connector=postgresql, name=console, ts_ns=1725352004522681000, ts_ms=1725352004522, snapshot=false, db=employee, table=employee}, CamelDebeziumTimestamp=1725352004901, CamelMessageTimestamp=1725352004901, Content-Type=application/json}
2024-09-03 13:56:45,189 INFO  [FromPostgres] (Camel (camel-1) thread #1 - DebeziumConsumer) UPDATE: {"schema":{"type":"STRUCT","optional":true,"fields":[{"name":"emp_no","index":0,"schema":{"type":"INT32","optional":false,"defaultValue":0}},{"name":"birth_date","index":1,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}},{"name":"first_name","index":2,"schema":{"type":"STRING","optional":false}},{"name":"last_name","index":3,"schema":{"type":"STRING","optional":false}},{"name":"gender","index":4,"schema":{"type":"STRING","optional":false}},{"name":"hire_date","index":5,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}}],"fieldsByName":{"last_name":{"name":"last_name","index":3,"schema":{"type":"STRING","optional":false}},"hire_date":{"name":"hire_date","index":5,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}},"gender":{"name":"gender","index":4,"schema":{"type":"STRING","optional":false}},"emp_no":{"name":"emp_no","index":0,"schema":{"type":"INT32","optional":false,"defaultValue":0}},"first_name":{"name":"first_name","index":2,"schema":{"type":"STRING","optional":false}},"birth_date":{"name":"birth_date","index":1,"schema":{"type":"INT32","optional":false,"name":"io.debezium.time.Date","version":1}}},"name":"console.public.employee.Value"},"values":[12001,7213,"SR","K","F",7214]}
```

## Why Use This?

- **Because Logs Are Life**: You'll know exactly what's happening in your database, down to the tiniest insert, update, or delete.
- **Because It's Fun**: Who says CDC can't be entertaining?
- **Because It Works**: Reliable, extendable, and ready to make your life easier.

## Contributing
If you think you can make this even more fun, feel free to fork, extend, and send a pull request.


## Let's Connect (Or Hire Me!)
If you find yourself hopelessly enchanted by this repository, or if you’re thinking, "This person should definitely be on my team," then we should chat. Whether it's to discuss this project, share some database gossip, or to offer me an exciting job (because who wouldn't want that?), you can connect with me on [LinkedIn](https://www.linkedin.com/in/rajat-nigam-877208127/).