class Expr():
    pass

class Value(Expr):
    def __init__(self, val):
        self.val = val

    def __repr__(self):
        return 'Val(' + str(self.val) + ')'

    def evaluate(self):
        return self.val

class Binop(Expr):
    def __init__(self, op, left, right):
        self.op = op
        self.left = left
        self.right = right

    def __repr__(self):
       return f"{self.op}({self.left}, {self.right})"

    def evaluate(self, context):
        eval_left = self.left.evaluate(context)
        eval_right = self.right.evaluate(context)
        import ipdb; ipdb.set_trace()

        function = context(self.op)

class Unop(Expr):
    def __init__(self, op, expr):
        self.op = op
        self.expr = expr

    def __repr__(self):
        return f"{self.op} {self.expr}"

    def evaluate(self):
        eval_left = self.expr.evaluate()
        if self.op == "+":
            return eval_expr
        if self.op == "-":
            return - eval_expr

def add(x, y):
    return x + y

def sub(x, y):
    return x - y

def mult(x, y):
    return x * y

def div(x, y):
    return x / y

context_operateur = {
    "+": add,
    "-": sub,
    "*": mult,
    "/": div,

}

# 1 + 3 + - 4
expr1 = Binop("+", 
            left=Value(1),
            right=Binop("+",
                left=Value(3),
                right=Unop(".", Value(4))))

print (expr1)