from flask import Flask, jsonify

app = Flask(__name__)

@app.route('/')
def home():
    return jsonify(message="Welcome to my simple Flask API!")

@app.route('/status')
def status():
    return jsonify(status="OK", message="API is running smoothly +++")

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
