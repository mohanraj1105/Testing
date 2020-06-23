FROM ubuntu
COPY ./test.groovy sample/
RUN apt-get update && apt-get install -y \
python
CMD ['bin/bash','-c','ls -la']
