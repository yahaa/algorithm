from flask import Flask, url_for
from flask.ext import restful

app = Flask(__name__)
api = restful.Api(app)


class Hell(restful.Resource):
    def get(self):
        return {'hello': 'hello world'}


@app.route("/")
def index():
    return "hello world!"


api.add_resource(Hell, '/hello')

if __name__ == '__main__':
    app.run(debug=True)
