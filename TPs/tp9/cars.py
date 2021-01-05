import spec
from spec import specification, Attribute

@specification
class Engine(object):
    ...

@specification
class Vehicule(object):
    number_of_wheels = Attribute(int)
    engine = Attribute(Engine)
    

@specification
class Car(Vehicule):
    ...


header = spec.gen_class_header(Vehicule)
print(header)
body = spec.gen_class_body(Vehicule)
print(body)