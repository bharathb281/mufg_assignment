# mufg_assignment

Created and compiled in STS

Output file saved in resource folder(/src/main/resources/output.xml). 

Validated for some property of request data and thrown custom exception, using ExceptionHandler.

API -- POST http://localhost:9191/bot/operate

Request 

{
    "Position": {
        "Direction": "N",
        "X": 10,
        "Y": 10
    },
    "Move": [
        {
            "O": "1",
            "L": 90,
            "F": 10
        },
        {
            "O": "2",
            "R": 180,
            "B": 20
        }
    ]
}

Resonse 

Request Accepted


API -- GET http://localhost:9191/bot/location

Response 

{
    "position": {
        "direction": "E",
        "x": -20,
        "y": 10
    }
}