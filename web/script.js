// 平滑滚动
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            const offsetTop = target.offsetTop - 70;
            window.scrollTo({
                top: offsetTop,
                behavior: 'smooth'
            });
        }
    });
});

// 导航栏滚动效果
let lastScrollTop = 0;
const navbar = document.querySelector('.navbar');

window.addEventListener('scroll', () => {
    const scrollTop = window.pageYOffset || document.documentElement.scrollTop;

    if (scrollTop > 100) {
        navbar.style.boxShadow = '0 4px 12px rgba(0, 0, 0, 0.15)';
    } else {
        navbar.style.boxShadow = '0 2px 12px rgba(0, 0, 0, 0.1)';
    }

    lastScrollTop = scrollTop;
});

// 元素进入视口动画
const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -50px 0px'
};

const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.style.opacity = '1';
            entry.target.style.transform = 'translateY(0)';
        }
    });
}, observerOptions);

// 为需要动画的元素添加观察
document.addEventListener('DOMContentLoaded', () => {
    const animatedElements = document.querySelectorAll(
        '.feature-card, .step, .tech-item, .download-card, .doc-card'
    );

    animatedElements.forEach(el => {
        el.style.opacity = '0';
        el.style.transform = 'translateY(20px)';
        el.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
        observer.observe(el);
    });
});

// 下载按钮点击事件
document.querySelectorAll('.btn-download').forEach(btn => {
    btn.addEventListener('click', (e) => {
        if (btn.textContent === '即将推出') {
            e.preventDefault();
            alert('macOS 版本即将推出，敬请期待！');
        } else if (btn.textContent === '下载安装包') {
            e.preventDefault();
            alert('下载功能即将开放，请访问 GitHub Releases 页面获取最新版本。');
        }
    });
});

// 文档链接点击提示
document.querySelectorAll('.doc-link').forEach(link => {
    link.addEventListener('click', (e) => {
        e.preventDefault();
        alert('文档正在整理中，敬请期待！');
    });
});

// 响应式菜单（移动端）
const createMobileMenu = () => {
    const navbar = document.querySelector('.navbar .container');
    const navMenu = document.querySelector('.nav-menu');

    if (window.innerWidth <= 768 && !document.querySelector('.menu-toggle')) {
        const menuToggle = document.createElement('button');
        menuToggle.className = 'menu-toggle';
        menuToggle.innerHTML = '☰';
        menuToggle.style.cssText = `
            background: none;
            border: none;
            font-size: 28px;
            color: var(--text-primary);
            cursor: pointer;
            padding: 0;
        `;

        navbar.appendChild(menuToggle);

        menuToggle.addEventListener('click', () => {
            if (navMenu.style.display === 'flex') {
                navMenu.style.display = 'none';
            } else {
                navMenu.style.display = 'flex';
                navMenu.style.position = 'absolute';
                navMenu.style.top = '70px';
                navMenu.style.left = '0';
                navMenu.style.right = '0';
                navMenu.style.flexDirection = 'column';
                navMenu.style.background = 'white';
                navMenu.style.padding = '20px';
                navMenu.style.boxShadow = '0 4px 12px rgba(0, 0, 0, 0.1)';
            }
        });
    }
};

// 窗口大小改变时重新检查
window.addEventListener('resize', () => {
    const menuToggle = document.querySelector('.menu-toggle');
    const navMenu = document.querySelector('.nav-menu');

    if (window.innerWidth > 768) {
        if (menuToggle) menuToggle.remove();
        navMenu.style.display = 'flex';
        navMenu.style.position = 'static';
        navMenu.style.flexDirection = 'row';
        navMenu.style.padding = '0';
        navMenu.style.boxShadow = 'none';
    } else {
        createMobileMenu();
    }
});

// 初始化移动端菜单
createMobileMenu();

// 版本信息动态效果
const versionBadge = document.querySelector('.version-badge');
if (versionBadge) {
    setInterval(() => {
        versionBadge.style.transform = 'scale(1.1)';
        setTimeout(() => {
            versionBadge.style.transform = 'scale(1)';
        }, 200);
    }, 3000);
    versionBadge.style.transition = 'transform 0.2s ease';
}

console.log('懒猿 UniAPP 打包机官网已加载 🦥');