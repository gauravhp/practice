from PIL import Image
from urllib.request import urlopen


def fetch_page():
    img = Image.open(urlopen("https://eaglenews.in/wp-content/uploads/2021/06/EAGLE-NEWS-20-JUNE-2021_02.jpg"))
    img.show()

def main():
    fetch_page()


if __name__ == "__main__":
    main()
