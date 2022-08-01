import com.dda.ui.newsList.NewsListFragmentViewModelTest
import com.dda.ui.newsList.NewsListRepositoryTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.Suite

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(Suite::class)
@Suite.SuiteClasses(
    NewsListRepositoryTest::class,
    NewsListFragmentViewModelTest::class
)
class DDATestSuite {
}

