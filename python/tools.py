import collections
Card = collections.namedtuple('Card', ['rank', 'suit'])


class FrenchDeck:
    ranks = [str(n) for n in range(2, 11)] + list('JQKA')
    suits = 'spades diamonds clubs hearts'.split()

    def __init__(self):
        self._cards = [Card(rank, suit)
                       for suit in self.suits for rank in self.ranks]

    def __len__(self):
        return len(self._cards)

    def __getitem__(self, position):
        return self._cards[position]


class TT:
    a = 10
    b = 20


def outer(ab):

    def inner():
        print "before some_fun"
        res = ab()
        return res + 1
    return inner


@outer
def test():
    print 'im a test'
    return 2


class Flask():
    def __init__(self):
        print '11'
        self.routes = {}

    def route(self, route_str):
        print 2278
        print route_str + 'ajkldjsf'

        def decorator(f):
            print 33
            self.routes[route_str] = f
            return f
        return decorator

    def server(self, path):
        print 44
        view_function = self.routes.get(path)
        if view_function:
            return view_function()
        else:
            raise ValueError(
                'Route "{}"" has not been registered'.format(path))


if __name__ == '__main__':
    print 'main'
#     deck = FrenchDeck()
#     print len(deck)
#     print deck[0]
    # print test()
#     # t = TT()
# # print len(t)

    app = Flask()

    @app.route('/')
    def hello():
        print 'hello world!'
    print hello, 5675

    app.server('/')
