FROM postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB assignment
COPY ./database/assignment_schema.sql /docker-entrypoint-initdb.d/