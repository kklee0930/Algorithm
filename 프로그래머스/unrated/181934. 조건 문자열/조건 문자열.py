def solution(ineq, eq, n, m):
    if eq == '=':
        ineq += eq
    if ineq == '<=':
        return int(n <= m)
    elif ineq == '>=':
        return int(n >= m)
    elif ineq == '>':
        return int(n > m)
    else:
        return int(n < m)