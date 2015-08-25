
def main():
    r = open("stop.txt")
    w = open("insertStops.txt",'w')
    stops = r.read().splitlines()
    w.write("List<String> stops = new ArrayList<>();\n\n")
    for stop in stops:
        w.write("stops.add(\" "+stop+" \");\n")

if __name__ == "__main__":
    main()
