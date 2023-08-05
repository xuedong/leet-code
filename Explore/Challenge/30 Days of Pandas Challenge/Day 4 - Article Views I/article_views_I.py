import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    return views.loc[views['viewer_id'] == views['author_id']]['author_id'].rename('id').sort_values(ascending=True).to_frame().drop_duplicates()
