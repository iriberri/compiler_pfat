pf2013 Ejem7

decl

intset a, b, c, d;

begin
a:= {0, 1, 3, 5, 7, 9};
b:= {0, 4, 2, 4, 6, 4, 8};
c:= a union b;
d:= a intersec b;
print("Cardinal de a= " + int2str(card(a)));
print("Cardinal de b= " + int2str(card(b)));
print("Cardinal de c= " + int2str(card(c)));
print("Cardinal de d= " + int2str(card(d)));
end;
