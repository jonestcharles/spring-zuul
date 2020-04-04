DROP TABLE IF EXISTS assets;

CREATE TABLE assets (
  asset_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  organization_id   TEXT NOT NULL,
  asset_name        TEXT NOT NULL,
  asset_type        TEXT NOT NULL,
  comment           VARCHAR(100));


INSERT INTO assets (asset_id, organization_id, asset_name, asset_type, comment)
VALUES ('5d768595-9355-4465-bfdb-e707c5c8ab11', '7be28a0f-22e5-4ccf-a3b8-dc6a106a0dca', 'cash on hand', 'tangible', 'store under mattress');
INSERT INTO assets (asset_id, organization_id, asset_name, asset_type, comment)
VALUES ('b15bd123-68b3-4b69-85c9-b89f1a000a38', '7be28a0f-22e5-4ccf-a3b8-dc6a106a0dca', 'human capital', 'intangible', 'highly valuable');
INSERT INTO assets (asset_id, organization_id, asset_name, asset_type)
VALUES ('c6e6f7b0-6ba2-11ea-bc55-0242ac130003', '9d21c585-c395-4865-8951-cd30381fdf80', 'building', 'tangible');
INSERT INTO assets (asset_id, organization_id, asset_name, asset_type)
VALUES ('f38e4eee-6ba2-11ea-bc55-0242ac130003', '9d21c585-c395-4865-8951-cd30381fdf80', 'backhoe', 'tangible');