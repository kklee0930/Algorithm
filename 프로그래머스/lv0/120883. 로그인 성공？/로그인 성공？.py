def solution(id_pw, db):
    status = 'fail'
    for data in db:
        if data[0] == id_pw[0]:
            status = 'wrong pw'
            if data[1] == id_pw[1]:
                status = 'login'
        if status == 'login':
            break
    return status