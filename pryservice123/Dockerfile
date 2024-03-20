FROM python:3.9
LABEL image=pryservice123
WORKDIR /pryservice123
COPY requirements.txt .
RUN pip install -r requirements.txt
COPY main.py .

CMD ["python", "main.py"]
