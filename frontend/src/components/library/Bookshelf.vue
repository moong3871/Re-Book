<template>
    <div>
        <div class="bookshelf">
            <div class="book-grid">
                <ul>
                    <li> <BookCover src="https://images-na.ssl-images-amazon.com/images/I/51uLvJlKpNL._SX321_BO1,204,203,200_.jpg"/></li>
                    <li> <img src="https://damonza.com/wp-content/uploads/portfolio/fiction/The-prophecy_03.jpg"/></li>
                    <li> <img src="https://i.pinimg.com/564x/f7/c8/12/f7c812c9b0296cd9f119e33a06d9a256.jpg"/></li>
                    <li> <img src="https://images.penguinrandomhouse.com/cover/9781101931288"/></li>
                    <li> <img src="https://i.harperapps.com/covers/9780062698162/x510.jpg"/></li>
                </ul>
            </div>
            <div class="shelf-shadows"></div>
            <div class="shelf"></div>
        </div>
        <div class="bookshelf">
            <div class="book-grid">
                <ul>
                    <li> <img src="https://images.penguinrandomhouse.com/cover/9781101931288"/></li>
                    <li> <img src="https://i.harperapps.com/covers/9780062698162/x510.jpg"/></li>
                    <li> <img src="https://www.canva.com/learn/wp-content/uploads/2015/03/draculabramstoker-tb-800x0.jpg"/></li>
                    <li> <img src="https://images-na.ssl-images-amazon.com/images/I/51uLvJlKpNL._SX321_BO1,204,203,200_.jpg"/></li>
                    <li> <img src="https://damonza.com/wp-content/uploads/portfolio/fiction/The-prophecy_03.jpg"/></li>
                </ul>
            </div>
            <div class="shelf-shadows"></div>
            <div class="shelf"></div>
        </div>
    </div>
</template>

<script>
import BookCover from "@/components/common/BookCover.vue";

export default {
    name: "Bookshelf",
    components: {
        BookCover,
    },
}
</script>

<style>
    .bookshelf {
    width: 80%;
    margin: 5rem auto;
    text-align: center;
    position: relative;
    }

    .book-grid {
    z-index: 2;
    position: relative;
    transform: translateY(-15px);
    }
    .book-grid ul {
    list-style: none;
    padding: 0;
    margin: 0;
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    }
    .book-grid ul li {
    justify-self: center;
    }
    .book-grid ul img {
    display: block;
    box-shadow: 0px -5px 20px 2px rgba(0, 0, 0, 0.3);
    width: 200px;
    height: 300px;
    -o-object-fit: cover;
        object-fit: cover;
    }

    .shelf-shadows {
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 1rem;
    border-radius: 2px;
    z-index: 1;
    box-shadow: 0px -5px 3px 0px rgba(170, 170, 170, 0.2), 0px 15px 20px 0px rgba(170, 170, 170, 0.7), 0px 5px 5px 0px rgba(119, 119, 119, 0.3);
    }

    .shelf {
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 1rem;
    background-color: #f9f9f9;
    border-radius: 2px;
    z-index: 3;
    }
</style>